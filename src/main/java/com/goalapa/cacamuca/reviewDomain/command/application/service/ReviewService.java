package com.goalapa.cacamuca.reviewDomain.command.application.service;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import lombok.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;



    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Transactional
    public void saveReview(ReviewDTO reviewDTO, List<MultipartFile> reviewPicUrl) {
        LocalDate date = LocalDate.now();
        Review review = new Review(reviewDTO.getReviewContent(), reviewDTO.getCountry(), reviewDTO.getFoodType(), reviewDTO.getFoodName(), date, reviewDTO.getReviewRate(), reviewDTO.getMemberNo(), reviewDTO.getFoodNo()
                                    , reviewDTO.getReviewKeyword(), reviewDTO.getReviewPrice(), reviewDTO.getReviewLink());

        String root = "C:\\app-file";
        String filePath = root + "/uploadFiles";

        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : reviewPicUrl) {
            if (file.isEmpty()) {
                continue;
            }

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                String uniqueFileName = UUID.randomUUID().toString();
                File uploadDir = new File(filePath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String uploadPath = filePath + File.separator + uniqueFileName;
                file.transferTo(new File(uploadPath));

                fileNames.add(uniqueFileName);
            } catch (IOException e) {
            }
        }
        reviewRepository.save(review);
    }
}

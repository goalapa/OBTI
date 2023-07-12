package com.goalapa.cacamuca.reviewDomain.command.application.service;

import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.ReviewPic;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewPicRepository;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
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
    private final ReviewPicRepository reviewPicRepository;

    private static String root = "C:\\app-file";
    private static String filePath = root + "/uploadFiles";
    private static ReviewPic reviewPic = null;



    public ReviewService(ReviewRepository reviewRepository, ReviewPicRepository reviewPicRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewPicRepository = reviewPicRepository;
    }

    @Transactional
    public void saveReview(ReviewDTO reviewDTO, List<MultipartFile> reviewPicUrl) {
        LocalDate date = LocalDate.now();
        Review review = new Review(reviewDTO.getReviewContent(), reviewDTO.getCountry(), reviewDTO.getFoodType(), reviewDTO.getFoodName(), date, reviewDTO.getReviewRate(), reviewDTO.getMemberNo(), reviewDTO.getFoodNo()
                , reviewDTO.getReviewKeyword(), reviewDTO.getReviewPrice(), reviewDTO.getReviewLink());

        List<String> fileNames = new ArrayList<>();

        for (MultipartFile file : reviewPicUrl) {
            if (file.isEmpty()) {
                continue;
            }

            String fileName = StringUtils.cleanPath(file.getOriginalFilename());

            try {
                String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;;
                File uploadDir = new File(filePath);

                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                String uploadPath = filePath + File.separator + uniqueFileName;
                file.transferTo(new File(uploadPath));
                int review_no = 1;

                reviewPic = new ReviewPic(uploadPath, review_no);
                fileNames.add(uniqueFileName);
                reviewPicRepository.save(reviewPic);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        reviewRepository.save(review);
    }
}

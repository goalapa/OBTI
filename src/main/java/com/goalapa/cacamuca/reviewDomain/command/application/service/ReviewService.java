package com.goalapa.cacamuca.reviewDomain.command.application.service;

import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.Like;
import com.goalapa.cacamuca.likeDomain.command.domain.aggregate.entity.LikeId;
import com.goalapa.cacamuca.likeDomain.command.domain.repository.LikeRepository;
import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewDTO;
import com.goalapa.cacamuca.reviewDomain.command.application.dto.ReviewLikeDTO;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.Review;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.ReviewPic;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.vo.ReviewWriter;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewPicRepository;
import com.goalapa.cacamuca.reviewDomain.command.domain.repository.ReviewRepository;
import com.goalapa.cacamuca.reviewDomain.query.application.service.SelectReviewService;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final LikeRepository likeRepository;
    private final ReviewPicRepository reviewPicRepository;
    private final SelectReviewService selectReviewService;

    private static String root = "C:\\app-file";
    private static String filePath = root + "/uploadFiles";

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, LikeRepository likeRepository, ReviewPicRepository reviewPicRepository, SelectReviewService selectReviewService) {
        this.reviewRepository = reviewRepository;
        this.likeRepository = likeRepository;
        this.reviewPicRepository = reviewPicRepository;
        this.selectReviewService = selectReviewService;
    }

    @Transactional
    public void saveReview(ReviewDTO reviewDTO, List<MultipartFile> reviewPicUrl) {
        LocalDate date = LocalDate.now();
        ReviewWriter reviewWriter = new ReviewWriter();
        ReviewPic reviewPic = new ReviewPic();
        Review review = new Review(reviewDTO.getReviewContent(), reviewDTO.getCountry(), reviewDTO.getFoodType(), reviewDTO.getFoodName(), date, reviewDTO.getReviewRate(), reviewWriter, reviewDTO.getFoodNo()
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

    @Transactional
    public void countHeart(Integer no, Integer memberNo) {
        Review review = reviewRepository.findById(no).get();

        if(review.getLikeCnt()==null){
            review.setLikeCnt(0);
        }

        System.out.println("no = " + no);
        System.out.println("memberNo = " + memberNo);

        LikeId likeId = new LikeId();

        likeId.setReviewNo(no);
        likeId.setMemberNo(memberNo);

        review.setLikeCnt(review.getLikeCnt() + 1);

//        Like like =  likeRepository.findById(likeId).get();
//        ReviewLikeDTO reviewLike = new ReviewLikeDTO(like.getId().getMemberNo(), like.getId().getReviewNo());
    }
}

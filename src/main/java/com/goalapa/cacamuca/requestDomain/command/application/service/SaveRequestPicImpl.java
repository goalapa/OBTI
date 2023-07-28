package com.goalapa.cacamuca.requestDomain.command.application.service;

import com.goalapa.cacamuca.requestDomain.command.domain.aggregate.entity.RequestPic;
import com.goalapa.cacamuca.requestDomain.command.domain.repository.RequestPicRepository;
import com.goalapa.cacamuca.requestDomain.command.domain.service.SaveRequestPic;
import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity.ReviewPic;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SaveRequestPicImpl implements SaveRequestPic {
    private static String root = "C:\\app-file";
    private static String filePath = root + "/uploadFiles";

    private final RequestPicRepository requestPicRepository;

    public SaveRequestPicImpl(RequestPicRepository requestPicRepository) {
        this.requestPicRepository = requestPicRepository;
    }


    @Override
    @Transactional
    public void saveRequestPic(@RequestParam MultipartFile singleFile, int requestNo) {


        String fileName = StringUtils.cleanPath(singleFile.getOriginalFilename());

        try {
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
            File uploadDir = new File(filePath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String uploadPath = filePath + File.separator + uniqueFileName;
            singleFile.transferTo(new File(uploadPath));

            RequestPic requestPic = new RequestPic();
            requestPic.setRequestNo(requestNo);
            requestPic.setRequestUrl(uniqueFileName);

            requestPicRepository.save(requestPic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

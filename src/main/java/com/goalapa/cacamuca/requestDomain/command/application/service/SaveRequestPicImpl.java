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
    public void saveRequestPic(@RequestParam MultipartFile singleFile) {


        //File dir = new File(filePath);

//        if(!dir.exists()) {
//            dir.mkdirs();
//        }

//        String originFileName = singleFile.getOriginalFilename();
//
//        String ext = originFileName.substring(originFileName.lastIndexOf("."));
//
//        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
//
//        try {
//            singleFile.transferTo(new File(filePath  + "/" + savedName));
//        } catch (IOException e) {
//            new File(filePath + "/" + savedName).delete();
//        }
////        RequestPic requestPic = new RequestPic();
////        requestPic.setRequestUrl(filePath  + "/" + savedName);
//
//        RequestPic requestPic = new RequestPic();
//        requestPic.setRequestUrl(savedName);
//
//        requestPicRepository.save(requestPic);

        String fileName = StringUtils.cleanPath(singleFile.getOriginalFilename());

        try {
            String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;;
            File uploadDir = new File(filePath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            String uploadPath = filePath + File.separator + uniqueFileName;
            singleFile.transferTo(new File(uploadPath));

            RequestPic requestPic = new RequestPic();
            requestPic.setRequestUrl(uniqueFileName);

            requestPicRepository.save(requestPic);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

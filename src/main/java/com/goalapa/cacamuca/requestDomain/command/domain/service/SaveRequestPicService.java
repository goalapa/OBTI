package com.goalapa.cacamuca.requestDomain.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface SaveRequestPicService {

    void saveRequestPic(MultipartFile singleFile);
}

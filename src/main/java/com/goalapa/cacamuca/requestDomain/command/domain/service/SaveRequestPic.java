package com.goalapa.cacamuca.requestDomain.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

public interface SaveRequestPic {

    void saveRequestPic(MultipartFile singleFile, int requestNo);
}

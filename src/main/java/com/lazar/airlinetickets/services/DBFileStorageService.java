package com.lazar.airlinetickets.services;

import com.lazar.airlinetickets.exception.FileStorageException;
import com.lazar.airlinetickets.exception.MyFileNotFoundException;
import com.lazar.airlinetickets.model.DataBaseFile;
import com.lazar.airlinetickets.repository.DBFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class DBFileStorageService {

    @Autowired
    private DBFileRepository dbFileRepository;

    public DataBaseFile storeFile(MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequenth " + fileName);
            }

            DataBaseFile dbFile = new DataBaseFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);

        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public DataBaseFile getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}

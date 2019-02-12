package com.dream.fastdfs;

import com.luhuiguo.fastdfs.domain.StorePath;
import com.luhuiguo.fastdfs.service.FastFileStorageClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootFastdfsApplicationTests {
    @Autowired
    private FastFileStorageClient storageClient;


    @Test
    public void contextLoads() throws Exception {
        File file = new File("e:/readme.md");
        InputStream in = new FileInputStream(file);
        StorePath storePath = storageClient.uploadFile(in, in.available(), "md", null);
        System.out.println(storePath.getFullPath());
    }


    @Test
    public void delete() throws Exception {
        storageClient.deleteFile("group1/M00/00/00/wKgBb1xikGCALYQsAAAHfDB8loY7166.md");

    }

}


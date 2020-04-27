package com.posws.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

@Service
@EnableScheduling
@Slf4j
public class BackupService {

    @Value("${POSTGRES_DB:headhunter}")
    private String database;

    @Scheduled(cron = "0 0 4 * * *")
    public void dumpDatabase() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", "pg_dump --no-password --inserts " + database + " > /webapp/logs/dump.sql");
        Process process = processBuilder.start();

        StringBuilder output = new StringBuilder();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));

        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line + "\n");
        }

        int exitVal = process.waitFor();
        if (exitVal == 0) {
            log.info("Create database backup at " + new Date());
            return;
        }
        log.error("Failed to create database backup at " + new Date());

    }
}



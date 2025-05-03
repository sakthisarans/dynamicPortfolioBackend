package com.portfolio.auth.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.auth.model.ContentData.Content;
import com.portfolio.auth.model.ContentData.Github;
import com.portfolio.auth.model.contentresponse.*;
import com.portfolio.auth.model.contentresponse.achievements.AchievementSection;
import com.portfolio.auth.model.contentresponse.education.EducationSection;
import com.portfolio.auth.model.contentresponse.github.User;
import com.portfolio.auth.model.contentresponse.projects.BigProjects;
import com.portfolio.auth.model.contentresponse.skills.WhatIDo;
import com.portfolio.auth.model.contentresponse.talks.TalkSection;
import com.portfolio.auth.model.contentresponse.teckstack.ProficiencySection;
import com.portfolio.auth.model.contentresponse.workexperience.WorkExperiences;
import com.portfolio.auth.repository.ContentRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentRepository contentRepository;
    private final ObjectMapper mapper = new ObjectMapper();
    @GetMapping("/getcontent")
    private ResponseEntity<?> getContent(@RequestParam String domain) {
        Content content=contentRepository.findByDomain(domain);
        if(content==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
         Response contentResponse=new Response();
         contentResponse.setGreetings(mapper.convertValue(content.getGreetings(), Greetings.class));
         contentResponse.setSocialMediaLinks(mapper.convertValue(content.getSocialMediaLinks(), SocialMediaLinks.class));
         contentResponse.setResume(mapper.convertValue(content.getResume(), Resume.class));
         if(content.getGithub()!=null&&content.getGithub().isDisplay()&&content.getGithub().getUserName()!=null&&content.getGithub().getToken()!=null) {
             JSONObject githubData=getGithubData(content.getGithub());
             log.debug("Github Data:{}",githubData);
             log.debug("mapped data - {}",mapper.convertValue(githubData, User.class));
             contentResponse.setGitHub(new User(githubData));
         }
         contentResponse.setOpenSource(mapper.convertValue(content.getOpenSource(), OpenSource.class));
         contentResponse.setSkillsSection(mapper.convertValue(content.getSkillSet(), WhatIDo.class));
         contentResponse.setTeckStackSection(mapper.convertValue(content.getTeckStack(), ProficiencySection.class));
         contentResponse.setEducationSection(mapper.convertValue(content.getEducationSection(), EducationSection.class));
         contentResponse.setWorkExperiences(mapper.convertValue(content.getWorkExperiences(), WorkExperiences.class));
         contentResponse.setProjects(mapper.convertValue(content.getProjects(), BigProjects.class));
         contentResponse.setAchievementSection(mapper.convertValue(content.getAchievement(), AchievementSection.class));
         contentResponse.setTalkSection(mapper.convertValue(content.getTalks(), TalkSection.class));
         contentResponse.setHireable(content.isHireable());
         contentResponse.setContactMe(mapper.convertValue(content.getContactMe(), ContactMe.class));
         contentResponse.setTwitter(mapper.convertValue(content.getTwitter(), Twitter.class));
         contentResponse.setPodcastSection(mapper.convertValue(content.getPodcast(), PodcastSection.class));
         return new ResponseEntity<>(contentResponse, HttpStatus.OK);
        }
    }
    @PostMapping("/updateData")
    private ResponseEntity<?> updateData(@RequestParam String domain,@RequestBody Content newContent) {
        Content content=contentRepository.findByDomain(domain);
        if(content==null) {
            return new ResponseEntity<>("Content not found", HttpStatus.NOT_FOUND);
        }else {
            if(newContent.getGreetings()!=null) {
                content.setGreetings(newContent.getGreetings());
            }
            if(newContent.getSocialMediaLinks()!=null) {
                content.setSocialMediaLinks(newContent.getSocialMediaLinks());
            }
            if(newContent.getResume()!=null) {
                content.setResume(newContent.getResume());
            }
            if (newContent.getGithub() != null) {
                content.setGithub(newContent.getGithub());
            }
            if (newContent.getSkillSet() != null) {
                content.setSkillSet(newContent.getSkillSet());
            }
            if(newContent.getTeckStack()!=null) {
                content.setTeckStack(newContent.getTeckStack());
            }
            if(newContent.getEducationSection()!=null) {
                content.setEducationSection(newContent.getEducationSection());
            }
            if(newContent.getWorkExperiences()!=null) {
                content.setWorkExperiences(newContent.getWorkExperiences());
            }
            if (newContent.getProjects()!=null) {
                content.setProjects(newContent.getProjects());
            }
            if(newContent.getAchievement()!=null) {
                content.setAchievement(newContent.getAchievement());
            }
            if(newContent.getOpenSource()!=null) {
                content.setOpenSource(newContent.getOpenSource());
            }
            if(newContent.getTalks()!=null) {
                content.setTalks(newContent.getTalks());
            }
            if(newContent.getContactMe()!=null) {
                content.setContactMe(newContent.getContactMe());
            }
            if(newContent.getTwitter()!=null) {
                content.setTwitter(newContent.getTwitter());
            }
            if(newContent.getPodcast()!=null) {
                content.setPodcast(newContent.getPodcast());
            }
            if (newContent.getBlog()!=null) {
                content.setBlog(newContent.getBlog());
            }
            content.setHireable(newContent.isHireable());
            contentRepository.save(content);
            return new ResponseEntity<>("Content updated", HttpStatus.OK);
        }
    }

    private JSONObject getGithubData(Github github) {
        try {
            String query = "{\n" +
                    "  user(login:\"" + github.getUserName() + "\") {\n" +
                    "    name\n" +
                    "    bio\n" +
                    "    avatarUrl\n" +
                    "    location\n" +
                    "    pinnedItems(first: 6, types: [REPOSITORY]) {\n" +
                    "      totalCount\n" +
                    "      edges {\n" +
                    "        node {\n" +
                    "          ... on Repository {\n" +
                    "            name\n" +
                    "            description\n" +
                    "            forkCount\n" +
                    "            stargazers {\n" +
                    "              totalCount\n" +
                    "            }\n" +
                    "            url\n" +
                    "            id\n" +
                    "            diskUsage\n" +
                    "            primaryLanguage {\n" +
                    "              name\n" +
                    "              color\n" +
                    "            }\n" +
                    "          }\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}";
            String jsonRequest = "{\"query\": " + "\"" + query.replace("\"", "\\\"").replace("\n", "\\n") + "\"}";
            URL url = new URL("https://api.github.com/graphql");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + github.getToken());
            conn.setRequestProperty("User-Agent", "Java");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonRequest.getBytes("utf-8");
                os.write(input, 0, input.length);
            }
            int status = conn.getResponseCode();
            if (status != 200) {
                log.debug("Github API returned status code {}", status);
                return null;
            }
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;

            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();
log.debug("data -> {}", response.toString());
            return new JSONObject(response.toString()).getJSONObject("data");


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

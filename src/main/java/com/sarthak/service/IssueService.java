package com.sarthak.service;

import com.sarthak.entity.Issue;
import com.sarthak.entity.IssueStatus;
import com.sarthak.entity.User;
import com.sarthak.repository.IssueRepository;
import com.sarthak.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;

    public IssueService(IssueRepository issueRepository,
                        UserRepository userRepository) {
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
    }

    // ================= CREATE ISSUE =================
    public Issue createIssue(
            String title,
            String description,
            String category,
            Authentication authentication
    ) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Issue issue = new Issue();
        issue.setTitle(title);
        issue.setDescription(description);
        issue.setCategory(category);
        issue.setStatus(IssueStatus.OPEN);
        issue.setCreatedAt(LocalDateTime.now());
        issue.setCreatedBy(user);

        return issueRepository.save(issue);
    }

    // ================= MY ISSUES =================
    public List<Issue> getMyIssues(Authentication authentication) {
        String email = authentication.getName();

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return issueRepository.findByCreatedBy(user);
    }

    // ================= ASSIGNED ISSUES =================
    public List<Issue> getAssignedIssues(Authentication authentication) {
        String email = authentication.getName();

        User staff = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return issueRepository.findByAssignedTo(staff);
    }

    // ================= ASSIGN ISSUE =================
    public Issue assignIssueToStaff(Long issueId, Long staffId) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        User staff = userRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found"));

        issue.setAssignedTo(staff);
        issue.setStatus(IssueStatus.ASSIGNED);

        return issueRepository.save(issue);
    }

    // ================= UPDATE STATUS =================
    public Issue updateIssueStatus(
            Long issueId,
            IssueStatus newStatus,
            Authentication authentication
    ) {
        Issue issue = issueRepository.findById(issueId)
                .orElseThrow(() -> new RuntimeException("Issue not found"));

        issue.setStatus(newStatus);
        return issueRepository.save(issue);
    }
}

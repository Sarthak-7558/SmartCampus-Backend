package com.sarthak.controller;

import com.sarthak.dto.CreateIssueRequest;
import com.sarthak.entity.Issue;
import com.sarthak.entity.IssueStatus;
import com.sarthak.repository.IssueRepository;
import com.sarthak.service.IssueService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;
    private final IssueRepository issueRepository;

    public IssueController(IssueService issueService,
                           IssueRepository issueRepository) {
        this.issueService = issueService;
        this.issueRepository = issueRepository;
    }

    // ================= CREATE ISSUE (STUDENT) =================
    @PostMapping("/create")
    public ResponseEntity<?> createIssue(
            @RequestBody CreateIssueRequest request,
            Authentication authentication
    ) {
        issueService.createIssue(
                request.getTitle(),
                request.getDescription(),
                request.getCategory(),
                authentication
        );
        return ResponseEntity.ok("Issue created successfully");
    }

    // ================= MY ISSUES (STUDENT) =================
    @GetMapping("/my")
    public List<Issue> getMyIssues(Authentication authentication) {
        return issueService.getMyIssues(authentication);
    }

    // ================= ASSIGNED ISSUES (STAFF) =================
    @GetMapping("/assigned")
    public List<Issue> getAssignedIssues(Authentication authentication) {
        return issueService.getAssignedIssues(authentication);
    }

    // ================= UPDATE STATUS (STAFF) =================
    @PutMapping("/update-status")
    public Issue updateIssueStatus(
            @RequestParam Long issueId,
            @RequestParam IssueStatus status,
            Authentication authentication
    ) {
        return issueService.updateIssueStatus(issueId, status, authentication);
    }

    // ================= ALL ISSUES (ADMIN) =================
    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN')")
    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    // ================= ASSIGN ISSUE (ADMIN) =================
    @PutMapping("/assign")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> assignIssue(
            @RequestParam Long issueId,
            @RequestParam Long staffId
    ) {
        issueService.assignIssueToStaff(issueId, staffId);
        return ResponseEntity.ok("Issue assigned successfully");
    }
}

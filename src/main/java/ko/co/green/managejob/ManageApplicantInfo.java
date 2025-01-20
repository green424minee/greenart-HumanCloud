package ko.co.green.managejob;

import java.time.LocalDateTime;
import java.util.List;

import kr.co.greenart.resume.Resume;
import kr.co.greenart.resume.Education;
import kr.co.greenart.resume.Experience;
import kr.co.greenart.resume.License;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManageApplicantInfo {
    private int id;
    private int recruitment_id;
    private int user_id;
    private int resume_id;
    private String status;
    private LocalDateTime applied_at;
    
    private Resume resume;
    private Education education;
    private Experience experience;
    private List<License> licenses;
}

package com.portfolio.auth.model.ContentData.teckstack;

import lombok.Data;

import java.util.List;

@Data
public class ProficiencySection {
    private boolean viewSkillBars;
    private List<Experience> experience;
    private boolean displayCodersrank;
}

package com.example.mcppoc.mcp.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class HealthTools {

    @Tool(name = "health", description = "Returns application health status")
    public Map<String, Object> health() {
        return Map.of("status", "UP");
    }
}

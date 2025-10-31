package com.example.mcppoc.mcp.adapter;

import java.util.Map;

public interface McpAdapter {
    String name();
    Object execute(String toolName, Map<String, Object> args) throws Exception;
}

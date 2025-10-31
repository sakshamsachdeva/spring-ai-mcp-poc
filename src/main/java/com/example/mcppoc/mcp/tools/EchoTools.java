package com.example.mcppoc.mcp.tools;

import com.example.mcppoc.mcp.adapter.McpAdapter;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import java.util.Map;

@Component
public class EchoTools {

    private final McpAdapter adapter;

    public EchoTools(McpAdapter adapter) { this.adapter = adapter; }

    @Tool(name = "echo", description = "Echo back any payload")
    public Map<String, Object> echo(Map<String, Object> payload) throws Exception {
        Object result = adapter.execute("ping", payload);
        return Map.of("adapter", adapter.name(), "result", result);
    }

    @Tool(name = "sum", description = "Add two numbers: a + b")
    public Map<String, Object> sum(Map<String, Object> payload) throws Exception {
        Object result = adapter.execute("sum", payload);
        return Map.of("result", result);
    }
}

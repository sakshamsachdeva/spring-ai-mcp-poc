package com.example.mcppoc.mcp.adapter;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class GenericMcpAdapter implements McpAdapter {

    private final Map<String, Function<Map<String, Object>, Object>> tools = new HashMap<>();

    public GenericMcpAdapter() {
        tools.put("ping", (args) -> Map.of("pong", true, "echo", args));
        tools.put("sum", (args) -> {
            Number a = (Number) args.getOrDefault("a", 0);
            Number b = (Number) args.getOrDefault("b", 0);
            return Map.of("result", a.doubleValue() + b.doubleValue());
        });
    }

    @Override
    public String name() { return "generic-adapter"; }

    @Override
    public Object execute(String toolName, Map<String, Object> args) {
        var fn = tools.get(toolName);
        if (fn == null) throw new IllegalArgumentException("Unknown tool: " + toolName);
        return fn.apply(args);
    }
}

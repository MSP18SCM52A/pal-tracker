package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {
    private String port;
    private String memoryLimit;
    private String cfInstanceIndex;
    private String cfInstanceAddr;


    public EnvController(@Value("${PORT}") String port, @Value("${MEMORY_LIMIT}") String memoryLimit, @Value("${CF_INSTANCE_INDEX}") String cfInstanceIndex, @Value("${CF_INSTANCE_ADDR}") String cfInstanceAddr) {
        this.port = port;
        this.memoryLimit = memoryLimit;
        this.cfInstanceIndex = cfInstanceIndex;
        this.cfInstanceAddr = cfInstanceAddr;

    }

    public Map<String, String> getEnv() {
        Map<String, String> envMap = new HashMap<>();

        envMap.put("PORT", port);
        envMap.put("MEMORY_LIMIT", memoryLimit);
        envMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        envMap.put("CF_INSTANCE_ADDR", cfInstanceAddr);

        return envMap;
    }
}

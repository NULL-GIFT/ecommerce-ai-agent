package com.xxx.proj.ai;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

import static dev.langchain4j.service.spring.AiServiceWiringMode.EXPLICIT;

@AiService(
        wiringMode = EXPLICIT,
        streamingChatModel = "openAiStreamingChatModel",
        // shopconfig
        chatMemoryProvider = "chatMemoryProviderShop",
        tools = "shopTools",
        // shopconfig
        contentRetriever = "contentRetrieverShop"
)
public interface ShopAgent {

    @SystemMessage(fromResource = "shop-prompt-template.txt")
    Flux<String> chat(@MemoryId Long memoryId, @UserMessage String userMessage, @V("userId") String userId);
}

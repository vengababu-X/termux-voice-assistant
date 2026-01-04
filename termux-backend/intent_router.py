from llm.llama_runner import run_llm

COMMAND_KEYWORDS = {
    "wifi on": "WIFI_ON",
    "wifi off": "WIFI_OFF",
    "bluetooth on": "BT_ON",
    "bluetooth off": "BT_OFF",
    "open camera": "OPEN_CAMERA",
    "call emergency": "CALL_EMERGENCY"
}

def route_intent(text):
    for key, action in COMMAND_KEYWORDS.items():
        if key in text:
            return {
                "type": "action",
                "action": action
            }

    # Everything else → LLM
    response = run_llm(text)
    return {
        "type": "reply",
        "text": response
    }

import subprocess

MODEL_PATH = "../models/llm/model.gguf"
LLAMA_BINARY = "./llama.cpp/main"

def run_llm(prompt):
    full_prompt = f"You are a concise mobile assistant.\nUser: {prompt}\nAnswer briefly."

    try:
        result = subprocess.run(
            [LLAMA_BINARY, "-m", MODEL_PATH, "-p", full_prompt, "-n", "128"],
            capture_output=True,
            text=True
        )
        return result.stdout.strip()
    except Exception as e:
        return f"LLM error: {str(e)}"

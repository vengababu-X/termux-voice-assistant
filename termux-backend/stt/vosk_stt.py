import queue
import sounddevice as sd
import vosk
import json

MODEL_PATH = "../models/stt/vosk-model-small-en"

q = queue.Queue()

def callback(indata, frames, time, status):
    q.put(bytes(indata))

def listen():
    model = vosk.Model(MODEL_PATH)
    rec = vosk.KaldiRecognizer(model, 16000)

    with sd.RawInputStream(
        samplerate=16000,
        blocksize=8000,
        dtype="int16",
        channels=1,
        callback=callback
    ):
        while True:
            data = q.get()
            if rec.AcceptWaveform(data):
                result = json.loads(rec.Result())
                return result.get("text", "")

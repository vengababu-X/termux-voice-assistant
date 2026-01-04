from flask import Flask, request, jsonify
from intent_router import route_intent

app = Flask(__name__)

@app.route("/process", methods=["POST"])
def process():
    data = request.json
    text = data.get("text", "").lower()

    if not text:
        return jsonify({"error": "Empty input"}), 400

    result = route_intent(text)
    return jsonify(result)

if __name__ == "__main__":
    app.run(host="127.0.0.1", port=5000)

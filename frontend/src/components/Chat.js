import React, { useState } from "react";
import styles from "./Chat.module.css";

function Chat() {
  const [messages, setMessages] = useState([]);
  const [input, setInput] = useState("");

  const sendMessage = async () => {
    if (!input.trim()) return;

    const userMessage = { text: input, sender: "user" };
    setMessages([...messages, userMessage]);

    const response = await fetch("http://localhost:8080/api/doubt", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({ leetCodeUrl: input, question: "I have a doubt" }),
    });

    const data = await response.json();
    const botMessage = { text: data.hint, sender: "bot" };

    setMessages((prev) => [...prev, botMessage]);
    setInput("");
  };

  return (
    <div className={styles["chat-container"]}>
      <div>
        {messages.map((msg, index) => (
          <div
            key={index}
            className={styles.message}
            style={{ backgroundColor: msg.sender === "bot" ? "#d1fae5" : "#e5e7eb" }}
          >
            {msg.text}
          </div>
        ))}
      </div>
      <div className={styles["input-container"]}>
        <input
          type="text"
          value={input}
          onChange={(e) => setInput(e.target.value)}
          placeholder="Paste LeetCode URL here..."
        />
        <button onClick={sendMessage}>Send</button>
      </div>
    </div>
  );
}

export default Chat;

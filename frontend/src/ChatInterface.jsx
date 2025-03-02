import React, { useState } from 'react';


function ChatUI() {
  const [leetcodeUrl, setLeetcodeUrl] = useState('');
  const [doubt, setDoubt] = useState('');
  const [chat, setChat] = useState([]);

  const handleSend = async () => {
    if (!leetcodeUrl || !doubt) return;

    const userMessage = { sender: 'user', text: doubt };
    setChat([...chat, userMessage]);

    try {
      const response = await fetch('http://localhost:8080/api/doubt', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ leetCodeUrl: leetcodeUrl, doubt: doubt }),
      });

      const data = await response.json();
      console.log('Response from backend:', data); // Debug log

      const botMessage = { sender: 'bot', text: data.hint }; // Make sure this matches the backend response
      setChat([...chat, userMessage, botMessage]);

      setDoubt('');
      setLeetcodeUrl('');
    } catch (error) {
      console.error('Error sending message:', error);
      const errorMessage = { sender: 'bot', text: 'Oops! Something went wrong. Please try again later.' };
      setChat([...chat, userMessage, errorMessage]);
    }
  };

  return (
    <div className="min-h-screen flex flex-col items-center bg-gray-100 p-4">
      <h1 className="text-3xl font-bold mb-4">DSA Learning Chatbot</h1>
      <input
        type="text"
        placeholder="Enter LeetCode URL"
        value={leetcodeUrl}
        onChange={(e) => setLeetcodeUrl(e.target.value)}
        className="border p-2 rounded w-full max-w-md mb-2"
      />
      <input
        type="text"
        placeholder="Type your doubt here..."
        value={doubt}
        onChange={(e) => setDoubt(e.target.value)}
        className="border p-2 rounded w-full max-w-md mb-2"
      />
      <button
        onClick={handleSend}
        className="bg-blue-500 text-white p-2 rounded w-full max-w-md"
      >
        Send
      </button>
      <div className="bg-white w-full max-w-md p-4 mt-4 rounded shadow">
        {chat.map((message, index) => (
          <div
            key={index}
            className={`p-2 rounded my-1 ${
              message.sender === 'user' ? 'bg-blue-100 text-right' : 'bg-green-100 text-left'
            }`}
          >
            {message.text}
          </div>
        ))}
      </div>
    </div>
  );
}

export default ChatUI;

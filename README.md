# DSA-Learning-App
Here’s a short description:    **DSA Learning Assistant** – A simple chat-based web app that helps users understand and solve DSA problems by providing guided hints and thoughtful questions. Built with Spring Boot and React, integrated with GPT for interactive learning.  

The user interface of this project is a straightforward chat application that serves as a teaching tool for Data Structures and Algorithms (DSA) difficulties. By sending in their precise query together with the LeetCode link, users can submit a doubt regarding a DSA problem. Without providing answers outright, the program leverages GPT to build intuition and provide users cues.

**Setup Instructions**
1) Clone the Repository
2) Navigate to Project Directory
3) Set up Environment Variables
4) Run Backend 
5) Run Frontend

**Architecture**

>The application follows a client-server architecture:

>>Frontend: Built with React, providing an interactive and user-friendly chat interface. 

>>Backend: A Spring Boot application handling API requests and communicating with GPT.

>>GPT Integration: The backend sends user queries to the GPT model and returns helpful hints.


**Flow:**
1) User submits a LeetCode link and their doubt through the chat interface.
2) The frontend sends this data to the backend.
3) The backend identifies the problem type and formulates a suitable prompt.
4) The prompt is sent to the GPT API.
5) GPT’s response is returned and displayed in the chat interface.

**How to Use the Application:**
1) Open the application in your browser.
2) Enter the LeetCode problem URL.
3) Type your specific doubt about the problem.
4) Click "Submit" to receive guidance from the chatbot.
5) The chatbot provides hints and suggestions to help you approach the problem without revealing the complete solution.

>GPT Integration Details : 
> > **Prompt Design:** The backend has a set of predefined prompts categorized by problem types (array, recursion, graph).
> 
> > **Dynamic Hint Generation:** Based on the user’s query, the backend identifies the problem type and selects a relevant prompt.
> 
> > **GPT API Call:** The backend sends the prompt to GPT and retrieves a thoughtful, guiding response.
> 
> > **Response Management:** The response is sent back to the frontend and displayed as a chat message.

This architecture ensures that users receive insightful hints tailored to their specific doubts, promoting a deeper understanding of DSA concepts.
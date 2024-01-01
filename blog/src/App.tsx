import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import PostsPage from "./page/post";
import PostPreviewsPage from "./page/post/previews";

function App() {

  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<PostsPage/>}/>
          <Route path="/test" element={<PostPreviewsPage/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;

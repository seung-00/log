import React from "react";
import PostPreviews from "../../component/post/preview/PostPreviews";

export default function PostListPage() {

  return (
      <div className={"page_container"}>
        <header className={"header_container"}>
          Posts
        </header>
        <main className={"page_main"}>
          <PostPreviews/>
        </main>
        <footer className={"page_footer"}>
          <p>seung-00@naver.com</p>
        </footer>
      </div>
  )
}

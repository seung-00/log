import React from "react";
import PostPreviews from "../../component/post/preview/PostPreviews";

export default function PostListPage() {

  return (
      <div className={"page_container"}>
        <header>
          <h1>
            Posts
          </h1>
        </header>
        <main className={"page_main"}>
          <PostPreviews/>
        </main>
        <footer className={"page_footer"}>
          <p>seung-00</p>
        </footer>
      </div>
  )
}

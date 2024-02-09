import React from "react";
import PostDetail from "../../../component/post/detail";
import {useParams} from "react-router-dom";

export default function PostDetailPage() {
  const {id} = useParams()

  return (
      <div className={"page_container"}>
        <header className={"header_container"}>
          Post Detail
        </header>
        <main className={"page_main"}>
          {id && <PostDetail id={id}/>}
        </main>
        <footer className={"page_footer"}>
          <p>seung-00@naver.com</p>
        </footer>
      </div>
  )
}

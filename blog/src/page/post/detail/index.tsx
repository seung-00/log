import React from "react";
import PostDetail from "../../../component/post/detail";
import {useParams} from "react-router-dom";

export default function PostDetailPage() {
  const {id} = useParams()

  return (
      <div className={"page_container"}>
        <header>
          <h1>
            Post Detail
          </h1>
        </header>
        <main className={"page_main"}>
          {id && <PostDetail id={id}/>}
        </main>
        <footer className={"page_footer"}>
          <p>seung-00</p>
        </footer>
      </div>
  )
}

import React from "react";
import {useParams} from "react-router-dom";
import cn from 'classnames';
import PostDetail from "../../../component/post/detail";

export default function PostDetailPage() {
  const {id} = useParams()

  return (
      <div className={"page_container"}>
        <header className={"detail_header"}>
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

import React from "react";
import {useNavigate, useParams} from "react-router-dom";
import PostDetail from "../../../component/post/detail";

export default function PostDetailPage() {
  const {id} = useParams()
  const navigate = useNavigate();

  const navigateToPosts = () => {
    navigate("/posts")
  }

  return (
      <div className={"page_container"}>
        <header className={"detail_header_container"}>
          <p className={"detail_header"} onClick={navigateToPosts}>
            Holden's Directory
          </p>
        </header>
        {id && <PostDetail id={id}/>}
        <footer className={"page_footer"}>
          <p>seung-00@naver.com</p>
        </footer>
      </div>
  )
}

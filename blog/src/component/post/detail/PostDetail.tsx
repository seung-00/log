import React, {useEffect, useState} from "react";
import {axiosInstance} from "../../../common/axios";
import classNames from "classnames";
import MarkdownWrapper from "../markdown/MarkdownWrapper";

interface PostResponse {
  id: number
  title: string
  content: string
  updatedAt: string
}

interface ApiResponse<T> {
  data: T
}

const fetchPost = async (id: string) => {
  const res = await axiosInstance.get<ApiResponse<PostResponse>>(`/v1/posts/${id}`)

  return res.data
}

type Props = {
  id: string;
}

export default function PostDetail({id}: Props) {
  const [post, setPost] = useState<PostResponse>();

  useEffect(() => {
    (async () => {
      const post = await fetchPost(id)
      setPost(post.data)
    })()
  }, [id]);

  if (!post) {
    return <div>loading...</div>
  }

  return (
      <main>
        <div className={"py-5"}>
          <h1 className={"font-sans text-4xl font-semibold text-gray-800"}>
            <span>{post.title}</span>
          </h1>
          <p className={"text-gray-500 pt-1"}>
            {post.updatedAt}
          </p>
        </div>
        <hr/>
        <MarkdownWrapper content={post.content}/>
      </main>
  )
}

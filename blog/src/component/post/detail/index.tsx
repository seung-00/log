import React, {useEffect, useState} from "react";
import Markdown from "react-markdown";
import remarkGfm from "remark-gfm";
import rehypeHighlight from "rehype-highlight";
import {axiosInstance} from "../../../common/axios";
import {IMAGE_BASE_URL} from "../../../common/constant";

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

const getPath = (uri: string) => {
  const pattern = /[^/]+\.png/g;

  return pattern.exec(uri)?.[0]
}

const transformImageUri = (uri: string) => {
  if (!uri.startsWith("http") && uri.includes('.png')) {
    return `${IMAGE_BASE_URL}${getPath(uri)}`
  }

  return uri
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
      <main className={"detail_main"}>
        <div className={"detail_post_header_container"}>
          <p className={"detail_post_date"}>
            {post.updatedAt}
          </p>
          <h1 className={"detail_post_header"}>{post.title}</h1>
        </div>
        <Markdown
            rehypePlugins={[rehypeHighlight]}
            remarkPlugins={[remarkGfm]}
            urlTransform={transformImageUri}
        >
          {post.content}
        </Markdown>
      </main>
  )
}

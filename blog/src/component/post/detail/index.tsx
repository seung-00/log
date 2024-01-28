import React, {useEffect, useState} from "react";
import Markdown from "react-markdown";
import axios from "axios";
import remarkGfm from "remark-gfm";
import rehypeHighlight from "rehype-highlight";

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
  const res = await axios.get<ApiResponse<PostResponse>>(`http://localhost:8080/api/v1/posts/${id}`)

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
      <div className={"post_container"}>
        <Markdown
            rehypePlugins={[rehypeHighlight]}
            remarkPlugins={[remarkGfm]}>
          {post.content}
        </Markdown>
      </div>
  )
}

import React, {useEffect, useState} from "react";
import {axiosInstance} from "../../../core/axios";
import MarkdownWrapper from "../markdown/MarkdownWrapper";
import TOC, {TOCItem} from "./TOC";

interface PostResponse {
  id: number
  title: string
  content: string
  createdAt: string
  updatedAt: String
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
  headings: TOCItem[]
  onHeadingsExtracted: (headings: { id: string, text: string, level: number }[]) => void | null;
  activeId: string | null;
  onIntersectHeadings: (id: string) => void | null;
}

export default function PostDetail({id, headings, onHeadingsExtracted, activeId, onIntersectHeadings}: Props) {
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
            {post.createdAt}
          </p>
        </div>
        <hr/>
        <br/>
        <div className="lg:hidden block mb-4">
          <TOC items={headings} activeId={activeId}/>
        </div>
        <MarkdownWrapper content={post.content} onHeadingsExtracted={onHeadingsExtracted} onIntersectHeadings={onIntersectHeadings} />
      </main>
  )
}

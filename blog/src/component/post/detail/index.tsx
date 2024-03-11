import React, {useEffect, useState} from "react";
import Markdown from "react-markdown";
import remarkGfm from "remark-gfm";
import remarkMermaid from 'remark-mermaidjs'

import {axiosInstance} from "../../../common/axios";
import {IMAGE_BASE_URL} from "../../../common/constant";
import CodeBlock from "../markdown/CodeBlock";
import Pre from "../markdown/Pre";
import Img from "../markdown/Img";

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
  const pattern = /images\/(.+\.png)/;
  const match = pattern.exec(uri);

  return match ? `${match[1]}` : null;

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
          <h1 className={"font-mono mt-3 lg:mb-16 text-5xl font-extrabold"}>
            <span className={"lg:bg-gradient-to-r from-my-400 via-my-200 to-my-100 bg-[length:100%_14px] bg-no-repeat bg-bottom pb-5"}>{post.title}</span>
          </h1>
        </div>
        <article className="
        prose prose-lg
        max-w-none
        prose-h1:border-l-8
        prose-h1:border-my-200
        prose-h1:pl-2
        pt-4 px-3
        prose-a:text-my-200 hover:prose-a:text-my-100">
          <Markdown
              // @ts-ignore
              // https://github.com/remarkjs/react-markdown/issues/680
              remarkPlugins={[remarkGfm, remarkMermaid]}
              urlTransform={transformImageUri}
              components={{
                img: Img,
                code: CodeBlock,
                pre: Pre
              }}>
            {post.content}
          </Markdown>
        </article>
      </main>
  )
}

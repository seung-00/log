import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {axiosInstance} from "../../../common/axios";

interface PostPreviewResponse {
  id: number
  title: string
  updatedAt: string
}

interface ApiResponse<T> {
  data: T
}

const fetchPostPreviews = async () => {
  const res = await axiosInstance.get<ApiResponse<PostPreviewResponse[]>>("/v1/posts/previews")

  return res.data
}

export default function PostPreviews() {
  const [previews, setPreviews] = useState<PostPreviewResponse[]>();

  useEffect(() => {
    (async () => {
      const postPreviews = await fetchPostPreviews()
      setPreviews(postPreviews.data)
    })()
  }, []);

  if (!previews) {
    return <div>loading...</div>
  }

  return (
      <main className={"preview_main"}>
        <ul className={"preview_list"}>
          {previews.map((post) => {
            return (
                <li key={post.id} className={"preview_post"}>
                  <p>
                    {post.updatedAt}
                  </p>
                  <Link to={`/posts/${post.id}`}>
                    <p className={"post_title"}>
                      {post.title}
                    </p>
                  </Link>
                </li>
            )
          })}
        </ul>
      </main>
  )
}

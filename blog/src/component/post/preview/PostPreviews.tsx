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
      <div>
        {previews.map((post) => {
          return (
              <Link key={post.id} to={`/posts/${post.id}`}>
                <p>
                  {post.title}
                  -
                  {post.updatedAt}
                </p>
              </Link>
          )
        })}
      </div>
  )
}

import axios from "axios";
import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";

interface PostPreviewResponse {
  id: number
  title: string
  updatedAt: string
}

interface ApiResponse<T> {
  data: T
}

const fetchPostPreviews = async () => {
  const res = await axios.get<ApiResponse<PostPreviewResponse[]>>("http://localhost:8080/api/v1/posts/previews")

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

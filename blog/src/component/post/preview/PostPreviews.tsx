import axios from "axios";
import {useEffect, useState} from "react";

interface PostPreview {
  id: number
  title: string
}

interface ApiResponse<T> {
  data: T
}

const fetchPostPreviews = async () => {
  const res = await axios.get<ApiResponse<PostPreview[]>>("http://localhost:8080/api/v1/posts/previews")

  return res.data
}

export default function PostPreviews() {
  const [data, setData] = useState<PostPreview[]>();

  useEffect(() => {
    (async () => {
      const postPreviews = await fetchPostPreviews()
      setData(postPreviews.data)
    })()
  }, []);

  if (!data) {
    return <div>loading...</div>
  }

  return (
    <div>
      {data.map((post) => {
        return (
          <div key={post.id}>
            <h1>{post.title}</h1>
          </div>
        )
      })}
    </div>
  )
}

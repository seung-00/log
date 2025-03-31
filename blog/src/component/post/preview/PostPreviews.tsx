import React, {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import {axiosInstance} from "../../../common/axios";
import classNames from "classnames";

interface PostPreviewResponse {
  id: number
  title: string
  createdAt: string
}

interface ApiResponse<T> {
  data: T
}

const fetchPostPreviews = async () => {
  const res = await axiosInstance.get<ApiResponse<PostPreviewResponse[]>>("/v1/posts/previews")

  return res.data
}

const formatDateWithIntl = (dateString: string) => {
  const date = new Date(dateString);
  const options = {
    year: 'numeric',
    month: '2-digit',
    day: '2-digit',
  } as const;
  const formatter = new Intl.DateTimeFormat('en-US', options);
  return formatter.format(date);
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
      <main>
        <h2 className={classNames("text-2xl", "text-gray-500", "italic")}>Recent</h2>
        <br/>
        <ul className={"list-disc"}>
          {previews.map((post) => {
            return (
                <li key={post.id} className={"leading-loose"}>
                  <Link to={`/posts/${post.id}`} className={classNames("text-blue-800", "font-medium", "hover:underline")}>
                    <span>
                      {formatDateWithIntl(post.createdAt)}
                    </span>
                    {"  -   "}
                    <span>
                      {post.title}
                    </span>
                  </Link>
                </li>
            )
          })}
        </ul>
      </main>
  )
}

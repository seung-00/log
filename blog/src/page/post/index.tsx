import Post from "../../component/post";

export default function PostsPage() {
  const post = "# hello world"

  return (
    <Post title={"first post"} body={post} />
  )
}

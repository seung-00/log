import React from "react";
import PostPreviews from "../../component/post/preview/PostPreviews";
import Layout from "../../component/core/Layout";
import Header from "../../component/core/Header";
import Footer from "../../component/core/Footer";

export default function PostListPage() {

  return (
      <Layout>
        <Header/>
        <PostPreviews/>
        <Footer/>
      </Layout>
  )
}

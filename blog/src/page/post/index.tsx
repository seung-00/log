import React from "react";
import PostPreviews from "../../component/post/preview/PostPreviews";
import Header from "../../component/core/Header";
import Footer from "../../component/core/Footer";
import PageContainer from "../../component/core/PageContainer";

export default function PostListPage() {

  return (
      <PageContainer>
        <Header/>
        <PostPreviews/>
        <Footer/>
      </PageContainer>
  )
}

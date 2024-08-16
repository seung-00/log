import React from "react";
import {useParams} from "react-router-dom";
import PostDetail from "../../../component/post/detail/PostDetail";
import Header from "../../../component/core/Header";
import Footer from "../../../component/core/Footer";
import Layout from "../../../component/core/Layout";

export default function PostDetailPage() {
  const {id} = useParams()

  return (
      <Layout>
        <Header/>
        {id && <PostDetail id={id}/>}
        <Footer/>
      </Layout>
  )
}

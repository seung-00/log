import React, {useState} from "react";
import {useLocation} from "react-router-dom";
import PostDetail from "../../../component/post/detail/PostDetail";
import Header from "../../../component/core/Header";
import Footer from "../../../component/core/Footer";
import TOC, {TOCItem} from "../../../component/post/detail/TOC";
import PageContainer from "../../../component/core/PageContainer";

export default function PostDetailPage() {
  const location = useLocation();
  const [headings, setHeadings] = useState<TOCItem[]>([]);
  const [activeId, setActiveId] = useState<string | null>(null);

  const state = location.state as { id: string };
  const id = state?.id;

  return (
      <div className="lg:flex justify-center">
        <div className="hidden lg:block basis-1/5"/>
        <PageContainer>
          <Header/>
          {id && <PostDetail
              id={id}
              headings={headings}
              onHeadingsExtracted={setHeadings} activeId={activeId}
              onIntersectHeadings={setActiveId}
          />
          }
          <Footer/>
        </PageContainer>
        <div className="
          hidden lg:block
          sticky top-20 self-start
          basis-1/5
          ">
          <div className="my-8 mr-auto">
            <TOC items={headings} activeId={activeId}/>
          </div>
        </div>
      </div>
  )
}

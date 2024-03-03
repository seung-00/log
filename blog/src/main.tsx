import React from 'react';
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import ErrorPage from "./page/common/error";
import PostListPage from "./page/post";
import PostDetailPage from "./page/post/detail";


const router = createBrowserRouter([
  {
    path: "/",
    element: <h1 className={"underline"}>Hello world!</h1>,
    errorElement: <ErrorPage/>,
  },
  {
    path: "/posts",
    element: <PostListPage/>,
    errorElement: <ErrorPage/>,
  },
  {
    path: "/posts/:id",
    element: <PostDetailPage/>,
    errorElement: <ErrorPage/>,
  },
  {
    path: "/error",
    element: <ErrorPage/>,
  },
  {
    path: "*",
    element: <ErrorPage status={404}/>,
  },
]);


function Main() {
  return (
      <RouterProvider router={router}/>
  );
}

export default Main;

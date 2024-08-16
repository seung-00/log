import React from "react";
import {useNavigate} from "react-router-dom";
import classNames from "classnames";

export default function Header() {
  const navigate = useNavigate();

  const navigateToPosts = () => {
    navigate("/posts")
  }

  return (
      <header className={classNames("text-center", "py-2")}>
        <a onClick={navigateToPosts} className={classNames("hover:underline", "cursor-pointer")}>
          <p className={classNames("text-xl")}>Holden's Directory</p>
        </a>
      </header>
  )
}

import classNames from "classnames";
import React from "react";

export default function Footer() {

  return (
      <>
        <br/>
        <hr/>
        <footer className={classNames("text-center", "py-3", "text-gray-600", "font-light")}>
          <p>seung-00@naver.com</p>
        </footer>
      </>
  )
}

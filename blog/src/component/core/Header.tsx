import React from "react";
import {useNavigate} from "react-router-dom";
import Fitting from "./Fitting";

export default function Header() {
  const navigate = useNavigate();

  const navigateToPosts = () => {
    navigate("/posts")
  }

  return (
      <Fitting>
        <header className="text-center py-3 w-full">
          <a onClick={navigateToPosts} className="hover:underline cursor-pointer text-gray-900">
            <p className="text-xl">Holden's Directory</p>
          </a>
        </header>
      </Fitting>
  )
}
